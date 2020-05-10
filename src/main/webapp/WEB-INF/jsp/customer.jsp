<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    

    <main>
        <form method="post" action="register">
            <div><input type="text" name="field1" placeholder="email"></div>
            <div><input type="text" name="field2" placeholder="title"></div>
            <div><input type="text" name="field3" placeholder="firstname"></div>
            <div><input type="text" name="field4" placeholder="lastname"></div>
            <div><input type="text" name="field5" placeholder="address-1"></div>
            <div><input type="text" name="field6" placeholder="address-2"></div>
            <div>
                <%-- <input type="text" name="field7" placeholder="city"> --%>
                <input list="sites" name="field7" placeholder="city">
                <datalist id="sites">
                    <option value="avalon">
                    <option value="ace-parks">
                </datalist>
            </div>
            <div><input type="text" name="field8" placeholder="postcode"></div>
            <div><input type="text" name="field9" placeholder="phonenumber"></div>

            <input type="submit" value="submit">
        </form> 

        <br>
        <div>
            <a href="sites"> View sites</a>
        </div>
    </main>

    <script src="/js/main.js"></script>
</body>
</html>