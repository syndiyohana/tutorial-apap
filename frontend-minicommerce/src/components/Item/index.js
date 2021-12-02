import React from "react";
import Button from "../button";
import classes from "./styles.module.css";

const Item = (props) => {
    const { id, title, price, description, category, handleEdit, handleDelete, handleAddToCart, qtyCart, handleChangeField} = props;
    return (
        <div className={classes.item}>
            <h3>{`ID ${id}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Price: ${price}`}</p>
            <p>{`Description: ${description}`}</p>
            <p>{`Category: ${category}`}</p>
            <Button action={handleEdit}>
            Edit
            </Button>
            <form>
                <input type="text" placeholder="Jumlah Item" name="jumlahItem" value={qtyCart} onChange={handleChangeField}/>
                <Button action= {handleAddToCart}>Add to Cart</Button>
            </form>
        </div>
    );
};
export default Item;