<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>MakeMyTrip</title>
</head>
<body>
    <h1>MakeMyTrip</h1>
    <h2>Book Your Train Ticket</h2>
    <h2>Your Train Ticket Info:</h2>
    
    <form action="/searchTicket">
        Ticket Id:
        <input type="text" name="ticketId" placeholder="Enter Ticket ID">
        <input type="submit" value="Search Ticket">
    </form>
    <hr>
    <table>
        <tr>
            <td>Ticket Number:</td>
            <td><input type="text" name="name" value="${ticket.ticketId}"></td>
        </tr>
        <tr>
            <td>Passenger Name:</td>
            <td><input type="text" name="name" value="${ticket.passengerName}"></td>
        </tr>
        <tr>
            <td>From:</td>
            <td><input type="text" name="from" value="${ticket.from}"></td>
        </tr>
        <tr>
            <td>To:</td>
            <td><input type="text" name="to" value="${ticket.to}"></td>
        </tr>
        <tr>
            <td>DOJ:</td>
            <td><input type="text" name="doj" value="${ticket.doj}"></td>
        </tr>
        <tr>
            <td>Train Number:</td>
            <td><input type="text" name="trainNumber" value="${ticket.trainNumber}"></td>
        </tr>
        <tr>
            <td>Cost:</td>
            <td><input type="text" name="cost" value="${ticket.ticketCost}"></td>
        </tr>
        <tr>
            <td>Status:</td>
            <td><input type="text" name="status" value="${ticket.ticketStatus}"></td>
        </tr>
    </table>
</body>
</html>