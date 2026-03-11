import createItem from  "./services/item.js";
import * as  cartService from  "./services/cart.js";


const  myCart = []
const myWhishList = []

console.log("Welcome to the your Cart");


const item1 = await  createItem("Hotwheels Ferrari", 20, 2);
const item2 = await  createItem("Hotwheels Lamborghini", 30, 3);

// adicionado itens
await cartService.default.addItem(myCart, item1);
await cartService.default.addItem(myCart, item2);
await cartService.default.addItem(myWhishList, item2);

// deletando itens
//await cartService.default.deleteItem(myCart,item2.name);
//await cartService.default.deleteItem(myCart,item1.name);

//await  cartService.default.removeItem(myCart,1);
await cartService.default.displayCart(myCart);


// console.log("My Cart total IS: R$ ");
//await cartService.default.calculateTotal(myCart);
const total = await cartService.default.calculateTotal(myCart);
console.log( " My Cart total IS: R$  " + total)
//console.log(item2.subtotal());

