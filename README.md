# 2.3 JPA with MongoDB
Create a Spring Boot Application that connects with MongoDB.

## Part 1: Basic Mongo DB configuration and Spring Boot Integration
How many customers were created in the database?

5

Where is the findAll method implemented?

El metodo findAll esta implementado en MongoRepository/CrudRepository y ya que la clase CustomerRepository hereda de MongoRepository, entonces ya esta implementado.

Suppose you have more than 1000 products in your database. How would you implement a method for supporting pagination and return pages of 50 products to your frontend?

Podemos crear un metodo que los clasifique por paginas y usar el metodo de findAll, pdiendole cada 50 productos 

How many products contain the "plus" word in their description?

4

How many products are returned by the findByDescriptionContaining query? Why?

En cada pagina retorna de a 2 productos.

Which are the collection names where the objects are stored? Where are those names assigned?

El nombre de la coleccion donde los objetos son guardados es el mismo nombre de la clase pero en minusculas.

