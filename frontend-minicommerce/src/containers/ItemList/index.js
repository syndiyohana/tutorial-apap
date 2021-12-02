import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
// import SearchBar from "../../components/search";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            search: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            searchValue:"",
            qtyCart:"",
        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearchItem = this.handleSearchItem.bind(this);
        this.handleAddCart = this.handleAddCart.bind(this);
    }
    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
    }

    handleAddItem() {
        this.setState({ isCreate:true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit: false });
    }
        
    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
        console.log(value)
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }

    async handleSearchItem(event) {
        event.preventDefault();
        const searchItems = [];
        try {
            const { data } = await APIConfig.get(`/item/${this.state.searchValue}`);
            if (data.result != null){
                searchItems.push(data.result)
                console.log(searchItems);
                this.setState({ search: searchItems});
            }
            else{
                alert("Oops input yang Anda masukkan salah");
            }
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleAddCart() {
        return(
            <form>
                <input type="text" placeholder="Search Item" name="searchValue" value={this.state.searchValue} onChange={this.handleChangeField}/>
            </form>
        )
    }
              

    render() {
        // console.log("render()");
        return (
            <div className={classes.itemList}>
                <h1 className={classes.title}>All Items</h1>
                <form>
                    <input type="text" placeholder="Search Item" name="searchValue" value={this.state.searchValue} onChange={this.handleChangeField}/>
                    <Button action= {this.state.searchValue.length>0
                    ? this.handleSearchItem : ""}>Search</Button>
                </form>
                <div>
                    {this.state.search.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            // quantity={item.quantity}
                            handleEdit={() => this.handleEditItem(item)}
                        />
                    ))}
                </div>
                
                <Button action={this.handleAddItem}> Add Item</Button>
                <div>
                    {this.state.items.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            handleEdit={() => this.handleEditItem(item)}
                            handleChangeField={() => this.handleChangeField}
                        />
                    ))}
                </div>
                <Modal
                show={this.state.isCreate || this.state.isEdit}
                handleCloseModal={this.handleCancel}
                modalTitle={this.state.isCreate
                ?"Add Item"
                :`Edit Item ID ${this.state.id}`}
                >
                    <form>
                        <input className={classes.textField} type="text" placeholder="Nama Item" name="title" value={this.state.title} onChange={this.handleChangeField}/>
                        <input className={classes.textField} type="number" placeholder="Harga" name="price" value={this.state.price} onChange={this.handleChangeField}/>
                        <textarea className={classes.textField} placeholder="Deskripsi" name="description" row="4" value={this.state.description} onChange={this.handleChangeField}/>
                        <input className={classes.textField} type="text" placeholder="Kategori" name="category" value={this.state.category} onChange={this.handleChangeField}/>
                        <input className={classes.textField} type="number" placeholder="qty" name="quantity" value={this.state.quantity} onChange={this.handleChangeField}/>
                        <Button action={this.state.isCreate
                        ? this.handleSubmitItem
                        : this.handleSubmitEditItem}>Create</Button>
                        <Button action={this.handleCancel}>Cancel</Button>
                    </form>
                </Modal>
            </div>
        );    
    }
}
export default ItemList;