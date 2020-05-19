import * as React from "react";
import {Component} from "react";
import Container from "react-bootstrap/Container";
import NavDropdown from "react-bootstrap/NavDropdown";
import "./sidebar.scss";
import ListGroup from "react-bootstrap/ListGroup";
import ListGroupItem from "react-bootstrap/ListGroupItem";
import {ICategory, IFilter} from "../../model/IFilter"


type SidebarState = {
    openMenu: boolean;
    filterData: IFilter;
    clickedItem: String;
    error: String;

}


export class Sidebar extends Component<any, SidebarState> {

    constructor(props: any) {
        super(props);
        this.state = {
            openMenu: false,
            filterData: {
                categories: [],
                discounts: null,
                priceRanges: null
            },
            clickedItem: null,
            error: ""
        }

        this.componentDidMount = this.componentDidMount.bind(this);
    }

    public componentDidMount() {

        fetch('http://104.45.189.171:8082/doc/appdata')
            .then(res => res.json())
            .then((data) => {
                console.log("categories data ", data);
                this.setState({ filterData: data })
            })
            .catch(console.log)

    }

    toggleCollapse = () => {
        this.setState({openMenu: !this.state.openMenu} );
    }

    render() {
        console.log("categories data ", this.state.filterData.categories);
        return (
            <div className="sidebar-wrapper">


                <Container className={"filter-container-style"}>
                        <Container>

                            <NavDropdown title={"Categories"} id={"nav-categories"}>
                                <ListGroup className={"list-style"}>
                                    {
                                        this.state.filterData.categories != null ? this.state.filterData.categories.map((category: ICategory, index) => {
                                            return  (
                                                <ListGroupItem action>{category.catName}</ListGroupItem>
                                            )
                                            }
                                        ) : undefined
                                    }
                                </ListGroup>
                            </NavDropdown>

                        </Container>

                        <Container>
                            <NavDropdown title={"Price Ranges"} id={"nav-categories"}>
                                <ListGroup className={"list-style"}>

                                    {
                                        this.state.filterData  && this.state.filterData.priceRanges ?
                                        Object.values(this.state.filterData.priceRanges).map((value:String, index) => {
                                            return (
                                                <ListGroupItem action>{value}</ListGroupItem>
                                            )

                                        }) : undefined

                                    }

                                </ListGroup>
                            </NavDropdown>
                        </Container>

                        <Container>
                            <NavDropdown title={"Discount"} id={"nav-categories"}>
                                <ListGroup className={"list-style"}>
                                    {
                                        this.state.filterData  && this.state.filterData.discounts ?
                                        Object.values(this.state.filterData.discounts).map((value:String, index: number) => {
                                            return (
                                                <ListGroupItem action>{value}</ListGroupItem>
                                            )
                                        }) : undefined
                                    }
                                </ListGroup>

                            </NavDropdown>
                        </Container>



                </Container>

                <ListGroup>

                </ListGroup>

            </div>
        );
    }
}