# Prueba de conocimiento Junior Developer - Paramētā S.A.S

En esta prueba se va a desarrollar : 

- Un servicio Rest que reciba como parámetros los atributos del objeto empleado al ser invocado mediante el método POST.
- El servicio validará que los formatos de las fechas y que los atributos no vengan vacíos. Adicionalmente validaráque el empleado sea mayor de edad. Una vez se hayan
superado estas validaciones se almacernará la información en una base de datos mysql.
- El Servicio Web responderá con el objeto en estructura JSON, en el que se deberá adicionar la
siguiente información: Tiempo de Vinculación a la compañía (años, meses), Edad actual del empleado (años, meses y días)


### Prerequisitos

* [Gradle](https://gradle.org/) - Administrador de dependencias
* [Java 8](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) -  Entorno de desarrollo 
* [Git](https://git-scm.com/) - Sistema de control de versiones
* [Postman](https://www.postman.com/) - Plataforma API para contruir y usar APIs

## Instalación y ejecución mediante Gradle

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

