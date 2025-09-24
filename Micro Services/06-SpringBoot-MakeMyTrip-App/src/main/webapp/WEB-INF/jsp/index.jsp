<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MakeMyTrip</title>
</head>
<body>
    <h1>MakeMyTrip</h1>
    <h2>Book Your Train Ticket</h2>
    <form action="/bookTicket" method="post">
        <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>From:</td>
            <td><input type="text" name="from"></td>
        </tr>
        <tr>
            <td>To:</td>
            <td><input type="text" name="to"></td>
        </tr>
        <tr>
            <td>DOJ:</td>
            <td><input type="text" name="doj"></td>
        </tr>
        <tr>
            <td>Train Number:</td>
            <td><input type="text" name="trainNumber"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Book Ticket"></td>
        </tr>
    </table>
    </form>
    <a href="/search">Search Ticket</a>
</body>
</html>