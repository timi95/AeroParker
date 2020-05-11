(function(){
    console.log("Hello World!");




    let email_field = document.getElementById("email-field");

    email_field.onblur = inputBlur;

    email_field.onfocus = inputFocus;


    function inputBlur() {
        // email_field.value = 'Focus has been lost';
        console.log('Focus has been lost');
        fetch('http://localhost:8080/email_exists/'+email_field.value, {
            method: 'POST'
        })
        .then((resp) => resp.json())
        .then(function(data){
            console.log("This is the result of the email input: ",data);
            if (data && email_field.value != '') {
                alert("This email already exists");
            } 
        });
    }
    
    function inputFocus() {
        console.log('Focus is here');
    }    

})();
