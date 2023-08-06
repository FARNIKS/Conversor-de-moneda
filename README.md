# CONVERSOR ALURA

## Descripción de proyecto
Es un reto de programación de ONE (Oracle Next Education), en una interfaz gráfica debemos hacer una conversión de divisas con los datos ingresados por el usuario.

Requisitos:

- El convertidor de moneda debe:

      - Convertir de la moneda de tu país a Dólar
      - Convertir de la moneda de tu país  a Euros
      - Convertir de la moneda de tu país  a Libras Esterlinas
      - Convertir de la moneda de tu país  a Yen Japonés
      - Convertir de la moneda de tu país  a Won sur-coreano

- Recordando que también debe ser posible convertir inversamente, es decir:

       - Convertir de Dólar a la moneda de tu país
       - Convertir de Euros a la moneda de tu país
       - Convertir de Libras Esterlinas a la moneda de tu país
       - Convertir de Yen Japonés a la moneda de tu país
       - Convertir de Won sur-coreano a la moneda de tu país

También colocar otro conversor como: Temperatura, velocidad, etc. Uno o los que quiera.



# Interfaz-Conversor
El diseño del programa implementa un estilo pixel art amigable y llamativo a la vista del usuario, implementando distintas funciones, como:
- No permite seleccionar los mismos valores en las listas.
- Se actualizan los valores al ingresar los datos por teclado y al seleccionar los elementos de la lista.

## Temas
Se cambia el diseño del conversor en modo claro y oscuro.

![ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/1c2437a1-2bea-46d3-8a37-29fcd01c6ce7)

##Idiomas
Se cambia el idioma a Ingles y Español 


[ruta-del-video.mp4]( https://github.com/FARNIKS/Conversor-Alura/assets/128429185/9980d423-0048-4d28-82c8-9467b24d50d5)

## Acerca de
Da una explicacion breve de lo que hace cada tipo de conversor y unos hipervivulos a las redes sociales de GitHub Y LinkedIn 

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/4683d42e-717c-4585-921f-44d63efecbe2)

# Conversores

## Moneda
Este es el conversor es el principal del reto de programación, se realizo implementando una **API Exchange** para que se actualice el valor de las divisas implementadas día a día, tarda entre 3 a 7 segundos al seleccionar la Moneda y a su vez cuando eligen los mismos valores en ambas listas, por hacer la conexión con la API y tener sus datos.
Pero al seleccionar directamente la moneda no vuelve a tardar cuando cambia de divisas a no ser que elija otro tipo de conversor y regrese a seleccionar moneda volverá a tardar lo mismo.

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/6ca9591a-0d27-4ad3-814e-8a71cbc8da81)

### Exchange Rate API
[**Exchange Rate API**](https://www.exchangerate-api.com)
Esta API de cambio de divisas tiene un plan gratuito de 1500 solicitudes al servidor, es el que se implementó en este proyecto, con las dependencias json para usar los datos de esta API para mostrar el cambio de divisas del día a día. Aquí se muestra las solicitudes de cada divisa para el conversor con el uso de la key de la API para acceder a los datos.

	 URL urlUSD = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/USD");
	 URL urlCOP = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/COP");
	 URL urlEUR = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/EUR");
	 URL urlGBP = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/GBP");
	 URL urlJPY = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/JPY");
	 URL urlKRW = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/KRW");

Hay más código donde se tiene q conectar con la api obtener los datos y las operaciones.

#### Dependencias API
- [json](https://mvnrepository.com/artifact/org.json/json)


## Temperatura
En este conversor es en grados de temperatura, Fahrenheit, Celsius y Kelvin, con sus fórmulas y operaciones correspondientes.

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/d8101540-cc93-417b-b2a6-8653003fac11)

## Velocidad
En este conversor se calculan las velocidades de Pie por segundo, Metros por Segundo, Milla por hora, Kilómetros por hora y Nudos.

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/1188ec29-288a-4acd-8b01-6b87c543d200)

## Tiempo

En este Calcula las distintas cantidades de tiempo, pero implentando las mas generales como: Milisegundo, Minuto, Segundo, Hora y Dia.

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/119a226b-c830-4001-8098-be55a2e8864a)

## Longitud
Se calcula las diferentes formas de medición como:Centímetro, Milímetro, Metro y Kilometro.

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/c8777659-5524-4ac8-8175-c0c744db9aff)


### Dependencias del conversor
[jgoodies-common-1.8.0.jar](https://mvnrepository.com/artifact/com.jgoodies/jgoodies-common/1.8.0)
[jgoodies-forms-1.8.0.jar](https://mvnrepository.com/artifact/com.jgoodies/jgoodies-forms/1.8.0)

# Instalacion
- Descargar el codigo en archivo ZIP.
- Exportarlo al IDE de preferencia.


