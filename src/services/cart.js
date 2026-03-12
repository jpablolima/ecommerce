async function addItem(userCart, item){
    userCart.push(item);
}

async  function calculateTotal(userCart) {
    const result =  userCart.reduce((total, item) => total + item.subtotal(), 0);
    return result;
    //console.log(result);
}

async function deleteItem(userCart, name){
    const index =  userCart.findIndex((item) => item.name === name)

    if (index !== -1) {
        userCart.splice(index, 1)
    }
}

async function removeItem(userCart, index){

    const deleteItem  = index -1;

    if (index => 0 && index <userCart.length){
        userCart.splice(deleteItem, 1)
    }
}


async function displayCart(userCart) {
    console.log("Cart List:");
    userCart.forEach((item, index) => {
        console.log(`${index + 1}. ${item.name} - R$ ${item.price}  | ${item.quantity}x|  Subtotal = ${item.subtotal()}`);
    });
}


export default {
    addItem,
    calculateTotal,
    deleteItem,
    removeItem,
    displayCart
}