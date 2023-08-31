function validateForm() {
    let productName = document.getElementById("productName").value;
    let price = document.getElementById("price").value;

    if (productName.trim() === "" || price === "") {
        alert("Please fill in Product Name and Price.");
        return false;
    }

    return true;
}