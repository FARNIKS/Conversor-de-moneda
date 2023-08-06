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


## Moneda
Este es el conversor es el principal del reto de programación, lo realice implementando una **API Exchange** para que se actualice el valor de las divisas implementadas día a día, tarda entre 3 a 7 segundos al seleccionar la Moneda y a su vez cuando eligen los mismos valores en ambas listas, por hacer la conexión con la API y tener sus datos.
Pero al seleccionar directamente la moneda no vuelve a tardar cuando cambia de divisas a no ser que elija otro tipo de conversor y regrese a seleccionar moneda volverá a tardar lo mismo.

[ruta-del-video.mp4](https://github.com/FARNIKS/Conversor-Alura/assets/128429185/6ca9591a-0d27-4ad3-814e-8a71cbc8da81)


[**Exchange Rate API**](https://www.exchangerate-api.com)
Esta API de cambio de divisas tiene un plan gratuito de 1500 solicitudes al servidor, es el que se implementó en este proyecto, con las dependencias json para usar los datos de esta API para mostrar el cambio de divisas del día a día. Aquí se muestra las solicitudes de cada divisa para el conversor con el uso de la key de la API para acceder a los datos.

	 URL urlUSD = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/USD");
	 URL urlCOP = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/COP");
	 URL urlEUR = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/EUR");
	 URL urlGBP = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/GBP");
	 URL urlJPY = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/JPY");
	 URL urlKRW = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/KRW");

#### Dependencias API
- [jsoup](https://jsoup.org/download)
- [json](https://mvnrepository.com/artifact/org.json/json)

