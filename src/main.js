import createItem from  "./services/item.js";
import * as  cartService from  "./services/cart.js"


const  myCart = []
const myWhishList = []

console.log("Welcome to the your Cart");


const item1 = await  createItem("Hotwheels Ferrari", 20, 2);
const item2 = await  createItem("Hotwheels Lamborghini", 30, 3);


await cartService.default.addItem(myCart, item1);
await cartService.default.addItem(myWhishList, item2);


console.log("My Cart total IS: R$ ");
await cartService.default.calculateTotal(myCart);

//console.log(item2.subtotal());

