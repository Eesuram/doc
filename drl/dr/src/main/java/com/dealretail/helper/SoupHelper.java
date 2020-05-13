package com.dealretail.helper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.dealretail.dto.CategorySite;
import com.dealretail.dto.Product;

@Component
public class SoupHelper {

	public List<Product> getProducts(CategorySite categorySite, String url) {
		List<Product> products = new ArrayList<Product>();
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (null == doc) {
			return null;
		}
		
		Elements elements = doc.select(categorySite.getProductKeyword());
		if (!elements.isEmpty()) {
			for (Element element : elements) {
				Product product = new Product();
				
				//product.setProductId(getProductId(element, categorySite.getProductKeyword()));
				product.setImageLink(getImageSourceLink(element, categorySite.getImageKeyword()));
				product.setOrgPrice(getOriginalPrice(element, categorySite.getOrgPriceKeyword()));
				product.setProductLink(getProductRedirectionLink(element, categorySite.getRedirectionKeyword()));
				product.setProductName(getProductShortDescription(element, categorySite.getDescriptionKeyword()));
				product.setSalePrice(getSalePrice(element, categorySite.getSalePriceKeyword()));
				product.setSavings(
						calculateSavings(product.getOrgPrice(), product.getSalePrice()));
				product.setSiteId(categorySite.getSiteId());
				product.setCatId(categorySite.getCatId());
				
				/*System.out.println("Product ID = " + product.getProductId() 
						+ ", Product Name = " + product.getProductName() +
						", Product Link = " + product.getProductLink());
						
				*/
				
				if (StringUtils.isNotEmpty(product.getProductName()) &&
						StringUtils.isNotEmpty(product.getImageLink()) &&
						StringUtils.isNotEmpty(product.getProductLink()) &&
						0 != product.getSalePrice()) {
					products.add(product);
				}
			}
		}
		
		return products;
	} 
	

	private long getProductId(Element element, String productKeyword) {
		// TODO Auto-generated method stub
		Elements elements = element.select(productKeyword);
		String productId = elements.attr("id");
		return Long.parseLong(productId);
	}


	private float getSalePrice(Element element, String salePriceKeyword) {
		// TODO Auto-generated method stub
		return getPrice(element, salePriceKeyword);
	}


	private String getProductShortDescription(Element element,
			String descriptionKeyword) {
		// TODO Auto-generated method stub
		String descripiton = null;
		
		Elements elements = element.select(descriptionKeyword);
		if (elements.hasText()) {
			descripiton = elements.text();
		}
		return descripiton;
	}


	private String getProductRedirectionLink(Element element,
			String redirectionKeyword) {
		// TODO Auto-generated method stub
		String redirectionLink = null;
		
		Elements elements = element.select(redirectionKeyword);
		if (elements.hasAttr("href")) {
			prefixBaseURI(elements.get(0), "href");
			attachSignature(element);
			redirectionLink = elements.attr("href");
		}
		return redirectionLink;
	}


	private float getOriginalPrice(Element element, String orgPriceKeyword) {
		// TODO Auto-generated method stub
		return getPrice(element, orgPriceKeyword);
	}


	private float getPrice(Element element, String priceKeyword) {
		float price = 0f;
		Elements elements = element.select(priceKeyword);
		
		if (elements.size() > 0 && elements.get(0).hasText()) {
			String text = elements.get(0).text();
			//System.out.println("TEXT :: Original Price :: " + text + " :: KeyWord :: " + orgPriceKeyword);
			if (text.contains("-")) {
				return 0;
			}
			text = text.replaceAll("[^0-9%.]", "");
			if ("".equals(text) && elements.size() > 1) {
				text = elements.get(1).text();
			}
			
			text = text.replaceAll("[^0-9%.]", "");
			if (text.startsWith(".")) {
				text = text.substring(1);
			} 
			
			if ("".equals(text)) {
				return 0;
			}
			
			price = Float.parseFloat(text);
		}
		
		return price;
	}


	private String getImageSourceLink(Element element, String imageKeyword) {
		// TODO Auto-generated method stub
		String imageSourceLink = null;
		
		Elements elements = element.select(imageKeyword);
		if (elements.hasAttr("src") || elements.hasAttr("data-original")) {
			String key = "";
			if (elements.hasAttr("src")) {
				key = "src";
			} else if (elements.hasAttr("data-original")) {
				key = "data-original";
			}
			
			prefixBaseURI(elements.get(0), key);
			imageSourceLink = elements.attr(key);
			
			int index = -1;
			if ((index = imageSourceLink.indexOf('?')) != -1) {
				imageSourceLink = imageSourceLink.substring(0, index);
			}
		}
		return imageSourceLink;
	}


	private float calculateSavings(float orgPrice, float salePrice) {
		// TODO Auto-generated method stub
		if (orgPrice != 0 && salePrice != 0) {
			float diff = orgPrice - salePrice;
			return (diff / orgPrice) * 100;
			
		}
		
		return 0;
	}

	private void prefixBaseURI(Element element, String key) {
		String value = element.attr(key);
		int index = element.baseUri().indexOf(".com");
		String baseURI = element.baseUri().substring(0, index + 4);

		if (value.startsWith("/") && !value.startsWith("//")) {
			value = baseURI + value;
			element.attr(key, value);
		}
	}

	private String attachSignature(Element link) {
		String href = link.attr("href");
		if (href.indexOf("?") != -1) {
			href = href + "&source=doc";
		} else {
			href = href + "?source=doc";
		}
		return href;
	}


	public int getItemCount(String browseLink, String itemCountKeyword) {
		int itemCount = 0;
		try {
			Document doc = Jsoup.connect(browseLink).get();
			Elements elements = doc.select(itemCountKeyword);
			String text = elements.text();
			itemCount = Integer.parseInt(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return itemCount;
	}

}
