<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello ${name}!</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
    

    <main>
        <h1>Customer Registration</h1>
        <form method="post" action="register">
            <div><input id="email-field" type="email" name="field1" placeholder="email" required></div>
            <div><input type="text" name="field2" placeholder="title" required></div>
            <div><input type="text" name="field3" placeholder="firstname" required></div>
            <div><input type="text" name="field4" placeholder="lastname" required></div>
            <div><input type="text" name="field5" placeholder="address-1" required></div>
            <div><input type="text" name="field6" placeholder="address-2"></div>
            <div>
                <select id="sites" name="field7">
                    <option value="Avalon City">Avalon City</option>
                    <option value="AceParks">AceParks</option>
                </select>
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