# Prueba de conocimiento Junior Developer - Paramētā S.A.S

En esta prueba se va a desarrollar : 

- Un servicio Rest que reciba como parámetros los atributos del objeto empleado al ser invocado mediante el método POST.
- El servicio validará que los formatos de las fechas y que los atributos no vengan vacíos. Adicionalmente validaráque el empleado sea mayor de edad. Una vez se hayan
superado estas validaciones se almacernará la información en una base de datos mysql.
- El Servicio Web responderá con el objeto en estructura JSON, en el que se deberá adicionar la
siguiente información: Tiempo de Vinculación a la compañía (años, meses), Edad actual del empleado (años, meses y días)


## Prerequisitos

* [Gradle](https://gradle.org/) - Administrador de dependencias
* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Entorno de desarrollo 
* [Git](https://git-scm.com/) - Sistema de control de versiones
* [Postman](https://www.postman.com/) - Plataforma API para contruir y usar APIs

## Instalacion y ejecución

### Instalación y ejecución mediante Gradle

1. Clone el repositorio

```
https://github.com/NicolasAguilera9906/Empleados-App-Parameta-S.A.S
```

2. Entre a la raiz del repositorio

![class](imagenes/ins1.png)

3. Compile el proyecto ingresando el siguiente comando en el CMD (Command Prompt)

```
gradlew bootrun
```

![class](imagenes/ins2.png)

4. Una vez el proyecto haya sido ejecutado correctamente observará el siguiente mensaje indicando que la aplicación ahora está corriendo en ```http://localhost:8080/```

![class](imagenes/ins3.png)

### Ejecución mediante endpoint en Heroku

1. También puede utilizar la siguiente dirección para hacer uso de la aplicación ```http://empleados-parameta-app.herokuapp.com/```

## Uso y casos de prueba

1. La aplicación nos permitirá añadir un nuevo empleado perteneciente a la compañia. Este empleado es recibido por medio del cuerpo de la petición utilizando HTTP POST en formato JSON. De esta manera, un empleado se verá de la siguiente manera : 

```
{
    "nombre":"Nicolás",
    "apellido":"Aguilera Contreras",
    "tipo_documento":"C.C",
    "numero_documento":"1014308690",
    "fecha_nacimiento":"1999/10/06",
    "fecha_vinculacion":"2022/01/01",
    "cargo":"Desarrollador",
    "salario":3000000
}
```

2. Para realizar la prueba de cada uno de los casos de prueba haremos uso de [Postman](https://www.postman.com/). Allí crearemos una nueva colleción con el método Post 
con la dirección ```http://empleados-parameta-app.herokuapp.com/api/v1/empleados``` si ejecutamos la aplicación desde Heroku, o ```http://localhost:8080/api/v1/empleados``` si ejecutamos la aplicación localmente

![class](imagenes/post1.png)

3. En la parte inferior especificaremos el cuerpo de la petición. Allí incluiremos al empleado en formato JSON :

![class](imagenes/post2.png)

### Añadir un nuevo empleado

1. Realizamos una peticion HTTP con el siguiente usuario :

![class](imagenes/post3.png)

2. El usuario es agregado correctamente a la base de datos y obtenemos la siguiente respuesta, en donde se incluye la edad del empleado y el tiempo que se encuentra trabajando en la compañia :

![class](imagenes/post4.png)

### Validación de campos vacíos

1. Vamos a no incluir un campo a proposito de tal manera que podamos observar la validación de campos vacíos. En este caso, no incluiremos el apellido del Empleado el cual se verá de la siguiente manera :

![class](imagenes/post5.png)

2. Vemos que al momento de enviar la petición se obtiene el siguiente mensaje de error validando el campo vacio:

![class](imagenes/post6.png)

3. También puede ocurrir el caso de que el atributo se encuentre presente pero no tenga valor. En este caso observamos que el apellido es igual a "" :

![class](imagenes/post7.png)

4. Al momento de enviar la petición obtenemos el mismo mensaje de error:

![class](imagenes/post8.png)

### Validación del formato de la fecha

1. La fecha debe seguir el siguiente formato : ```yyyy/mm/dd```. Vamos a incluir a proposito una fecha que no siga ese formato como se observa a continuación

![class](imagenes/post9.png)

2. Al momento de enviar la petición obtendremos el siguiente mensaje de error alertando sobre la petición incorrecta : 

![class](imagenes/post10.png)

3. Adicionalmente, también puede ocurrir que la fecha se encuentre en el futuro, lo cual no sería lógico ni para la fecha de nacimiento ni para le fecha de vinculación. Así, incluiremos este caso a proposito en la fecha de nacimiento :

![class](imagenes/post11.png)

4. Al momento de enviar la petición obtendremos el siguiente mensaje de error alertando sobre la fecha establecida en el futuro : 

![class](imagenes/post12.png)

### Validación Empleado mayor de edad



### Validación del formato de la fecha







### Front-End

1. First follow the steps to run the Back-End

2. Go to the ```/front``` directory

3. Change the ```/url``` variable in the ```js/webapp.js``` file to ```http://localhost:5000/celcius?value=```

![class](img/1.png)

3. Go to firefox and install [CORS EVERYWHERE](https://addons.mozilla.org/es/firefox/addon/cors-everywhere/#:~:text=The%20button%20can%20be%20found,enabled%2C%20CORS%20rules%20are%20bypassed)

4. Open the ```index.html``` file in your firefox browser

5. You will see the following page and you can convert the degrees

![class](img/2.png)

## Documentation

View [Documentation](https://nicolasaguilera9906.github.io/AREP-LAB7/)

## Architecture

### Class diagram

The SparkWebServer class is in charge of generating a Spark server with 2 endpoints:

/hello for a welcome message
/celcius for converting degrees Fahrenheit to degrees Celsius.

This class makes use of the TemperatureService class, which is an interface that will provide the temperature services. This class is implemented by the TemperatureServiceImpl class with a specific implementation of the temperature services. In this way, it will be easier for the user to make use of another implementation of these services.

![class](img/3.png)

### Deployment diagram

The client accesses a JS application deployed on Amazon S3. This application connects to a route implemented in API Gateway that accesses the service located in AWS EC2. This service is contained in a docker microcontainer and is responsible for performing the temperature calculation.

![deploy](img/4.png)

## Tests

### Demonstration videos

#### Application running on AWS EC2

[View video](https://www.youtube.com/watch?v=TSVzcVlf-To)

#### Application running on API Gateway

[View video](https://www.youtube.com/watch?v=YJnfLfLFuI0)

#### Accessing the application from Amazon S3

[View video](https://www.youtube.com/watch?v=yeHtSDbs7wM)

#### JUnit tests

A test was made to verify that the application correctly converts the degrees

![test](img/5.png)

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Spark](http://sparkjava.com/) - Micro framework for creating web applications in Java 8

## Author

* **Nicolás Aguilera Contreras** 

## License

This project is under GNU General Public License - see the [LICENSE](LICENSE) file for details.

