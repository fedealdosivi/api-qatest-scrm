Tecnologias usadas:
Maven, Java (8) y Retrofit.
Intellij (IDE)

- Agregar el proyecto al IDE y ejecutar maven para que descargue las dependencias correspondientes.
-Los Tests están divididos en dos suites, una para usuarios y otra para mensajes del foro, ambos dentro del package "Tests".
-Los models, builders, POJOs e interfaces se encuentran dentro del package forum.


Anotaciones:
Hay varios tests, particularmente los que son POST que arrojan un status code 409, pero quede todas formas la información es creada y puede ser chequeada en el swagger.

Me gustaría haberle podido agregar mas capas de abstracción al framework de manera que la capa de retrofit quedase fuera de la suite de tests, así que como haber podido desarrollar un clean up con los métodos de delete proporcionados, pero por cuestiones de tiempo no he podido.

Ante cualquier duda me pueden contactar a mi mail:

fedepalo13@gmail.com