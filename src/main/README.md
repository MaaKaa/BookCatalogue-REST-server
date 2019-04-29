REST server for the Book Catalogue app.

HOW IT WORKS?

Server implements a Book class, that contains: isbn, title, author, publisher and type fields. 

The only resource exposed by this REST service is a "book", which is composed of the following data fields:

    • id: book's id. Long type.
    • isbn: book's isbn. String type. 
    • title: book's title. String type. 
    • author: book's author. String type. 
    • publisher: book's publisher. String type.
    • type: book's type. String type. 

Available methods:

    • GET: /books/ - returns list of all books,
    • GET: /books/{id} - returns particular book info,
    • POST: /books/ - creates and saves new book based on the data provided by the user via an online form,
    • DELETE: /books/{id} - deletes particular book.
    • PUT: /books/{id} - changes particular book info. 

    
***
USED TOOLS/FRAMEWORKS:

    • Maven, Spring MVC, Jackson library for binding JSON objects.
