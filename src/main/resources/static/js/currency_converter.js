const currencyToInput = document.querySelector("#to");
const currencyFromInput = document.querySelector("#from");
const currencyFromType = document.querySelector("#from-type");
const currencyToType = document.querySelector("#to-type");

document.querySelector("#currency_converter_form").addEventListener("submit", async (event) => {
    event.preventDefault();
    const response = await fetch(`/api/currency_converter/get_data?from=${currencyFromType.value}&to=${currencyToType.value}&fromValue=${currencyFromInput.value}`);

   if(!response.ok)
       return;

   const data = await response.json();
   currencyToInput.value = data.data.sum_result;
});