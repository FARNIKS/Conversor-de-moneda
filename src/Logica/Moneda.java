package Logica;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class Moneda implements Conversor{
	 private ConversionEventListener conversionEventListener;
	 private  double usdToCopRate ,usdToEurRate , usdToGbpRate ,usdToJpyRate,usdToJKrwRate ,copToUsdRate , copToEurRate ,
	 copToGbpRate , copToJpyRate,copToKrwRate ,eurToCopRate , eurToUsdRate , eurToGbpRate , eurToJpyRate , eurToKrwRate ,
	 jpyToCopRate , jpyToEurRate ,jpyToGbpRate,jpyToUsdRate , jpyToKrwRate , krwToCopRate , krwToEurRate , krwToGbpRate,
	 krwToJpyRate ,krwToUsdRate,gbpToUsdRate,gbpToJpyRate,gbpToKrwRate, gbpToCopRate,gbpToEurRate;

	 public Moneda() {
		 String key="fee287066fbe1bddc7c965f8";
	        try {
	            // URL de la API
	            URL urlUSD = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/USD");
	            URL urlCOP = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/COP");
	            URL urlEUR = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/EUR");
	            URL urlGBP = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/GBP");
	            URL urlJPY = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/JPY");
	            URL urlKRW = new URL("https://v6.exchangerate-api.com/v6/"+key+"/latest/KRW");
	            // Realizar la solicitud HTTP
	            HttpURLConnection connectionUSD = (HttpURLConnection) urlUSD.openConnection();
	            HttpURLConnection connectionCOP = (HttpURLConnection) urlCOP.openConnection();
	            HttpURLConnection connectionEUR = (HttpURLConnection) urlEUR.openConnection();
	            HttpURLConnection connectionGBP = (HttpURLConnection) urlGBP.openConnection();
	            HttpURLConnection connectionJPY = (HttpURLConnection) urlJPY.openConnection();
	            HttpURLConnection connectionKRW=  (HttpURLConnection) urlKRW.openConnection();
	            
	            connectionUSD.setRequestMethod("GET");
	            connectionCOP.setRequestMethod("GET");
	            connectionEUR.setRequestMethod("GET");
	            connectionGBP.setRequestMethod("GET");
	            connectionJPY.setRequestMethod("GET");
	            connectionKRW.setRequestMethod("GET");
	            
	            connectionUSD.connect();
	            connectionCOP.connect();
	            connectionEUR.connect();
	            connectionGBP.connect();
	            connectionJPY.connect();
	            connectionKRW.connect();

	            // Obtener el código de respuesta de la solicitud
	            int responseCodeUSD = connectionUSD.getResponseCode();
	            int responseCodeCOP = connectionCOP.getResponseCode();
	            int responseCodeEUR = connectionEUR.getResponseCode();
	            int responseCodeGBP = connectionGBP.getResponseCode();
	            int responseCodeJPY = connectionJPY.getResponseCode();
	            int responseCodeKRW = connectionKRW.getResponseCode();
	            
	            if (responseCodeUSD != 200) {
	            	
	                throw new RuntimeException("Ocurrió un error: " + responseCodeUSD);
	                
	            }
	            if (responseCodeCOP != 200) {
	            
	                throw new RuntimeException("Ocurrió un error: " + responseCodeCOP);
	                
	            }
	            if (responseCodeEUR != 200) {
	            	
	                throw new RuntimeException("Ocurrió un error: " + responseCodeEUR);
	                
	            }
	            if (responseCodeGBP != 200) {
	            	
	                throw new RuntimeException("Ocurrió un error: " + responseCodeGBP);
	                
	            }
	            if (responseCodeJPY != 200) {
	            	
	                throw new RuntimeException("Ocurrió un error: " + responseCodeJPY);
	                
	            }
	            if (responseCodeKRW != 200) {
	            	
	                throw new RuntimeException("Ocurrió un error: " + responseCodeKRW);
	                
	            }else {
	                // Leer la respuesta JSON en una cadena
	            	
	                StringBuilder datoMonedaUSD = new StringBuilder();
	                StringBuilder datoMonedaCOP = new StringBuilder();
	                StringBuilder datoMonedaEUR = new StringBuilder();
	                StringBuilder datoMonedaGBP = new StringBuilder();
	                StringBuilder datoMonedaJPY = new StringBuilder();
	                StringBuilder datoMonedaKRW = new StringBuilder();
	                
	                Scanner registroMonedaUSD = new Scanner(urlUSD.openStream());
	                Scanner registroMonedaCOP = new Scanner(urlCOP.openStream());
	                Scanner registroMonedaEUR = new Scanner(urlEUR.openStream());
	                Scanner registroMonedaGBP = new Scanner(urlGBP.openStream());
	                Scanner registroMonedaJPY = new Scanner(urlJPY.openStream());
	                Scanner registroMonedaKRW = new Scanner(urlKRW.openStream());
	                
	                while (registroMonedaUSD.hasNext()) {
	                    datoMonedaUSD.append(registroMonedaUSD.nextLine());
	                }
	                while (registroMonedaCOP.hasNext()) {
	                    datoMonedaCOP.append(registroMonedaCOP.nextLine());
	                }
	                while (registroMonedaEUR.hasNext()) {
	                    datoMonedaEUR.append(registroMonedaEUR.nextLine());
	                }
	                while (registroMonedaGBP.hasNext()) {
	                    datoMonedaGBP.append(registroMonedaGBP.nextLine());
	                }
	                while (registroMonedaJPY.hasNext()) {
	                    datoMonedaJPY.append(registroMonedaJPY.nextLine());
	                }
	                while (registroMonedaKRW.hasNext()) {
	                    datoMonedaKRW.append(registroMonedaKRW.nextLine());
	                }
	       
	                registroMonedaUSD.close();
	                registroMonedaCOP.close();
	                registroMonedaEUR.close();
	                registroMonedaGBP.close();
	                registroMonedaJPY.close();
	                registroMonedaKRW.close();

	                // Crear un objeto JSONObject a partir de la cadena JSON
	                JSONObject USD = new JSONObject(datoMonedaUSD.toString());
	                JSONObject COP = new JSONObject(datoMonedaCOP.toString());
	                JSONObject EUR = new JSONObject(datoMonedaEUR.toString());
	                JSONObject GBP=  new JSONObject(datoMonedaGBP.toString());
	                JSONObject JPY = new JSONObject(datoMonedaJPY.toString());
	                JSONObject KRW = new JSONObject(datoMonedaKRW.toString());

	                // Ahora puedes acceder y utilizar los datos del JSONObject según tus necesidades.
	                // Por ejemplo, puedes obtener las tasas de cambio de monedas:
	                JSONObject conversionUSD = USD.getJSONObject("conversion_rates");
	                JSONObject conversionCOP = COP.getJSONObject("conversion_rates");
	                JSONObject conversionEUR = EUR.getJSONObject("conversion_rates");
	                JSONObject conversionGBP = GBP.getJSONObject("conversion_rates");
	                JSONObject conversionJPY = JPY.getJSONObject("conversion_rates");
	                JSONObject conversionKRW = KRW.getJSONObject("conversion_rates");
	                
	                //USD
	                 usdToCopRate = conversionUSD.getDouble("COP");
	                 usdToEurRate = conversionUSD.getDouble("EUR");
	                 usdToGbpRate = conversionUSD.getDouble("GBP");
	                 usdToJpyRate = conversionUSD.getDouble("JPY");
	                 usdToJKrwRate = conversionUSD.getDouble("KRW");
	                
	                //COP
	                 copToUsdRate = conversionCOP.getDouble("USD");
	                 copToEurRate = conversionCOP.getDouble("EUR");
	                 copToGbpRate = conversionCOP.getDouble("GBP");
	                 copToJpyRate = conversionCOP.getDouble("JPY");
	                 copToKrwRate = conversionCOP.getDouble("KRW");	
	                
	                //EUR
	                 eurToCopRate = conversionEUR.getDouble("COP");
	                 eurToUsdRate = conversionEUR.getDouble("USD");
	                 eurToGbpRate = conversionEUR.getDouble("GBP");
	                 eurToJpyRate = conversionEUR.getDouble("JPY");
	                 eurToKrwRate = conversionEUR.getDouble("KRW");
	                
	                //JPY
	                 jpyToCopRate = conversionJPY.getDouble("COP");
	                 jpyToEurRate = conversionJPY.getDouble("EUR");
	                 jpyToGbpRate = conversionJPY.getDouble("GBP");
	                 jpyToUsdRate = conversionJPY.getDouble("USD");
	                 jpyToKrwRate = conversionJPY.getDouble("KRW");
	                
	                //KRW
	                 krwToCopRate = conversionKRW.getDouble("COP");
	                 krwToEurRate = conversionKRW.getDouble("EUR");
	                 krwToGbpRate = conversionKRW.getDouble("GBP");
	                 krwToJpyRate = conversionKRW.getDouble("JPY");
	                 krwToUsdRate = conversionKRW.getDouble("USD");
	                 
	                 //GBP
	                 gbpToCopRate = conversionGBP.getDouble("COP");
	                 gbpToEurRate = conversionGBP.getDouble("EUR");
	                 gbpToKrwRate = conversionGBP.getDouble("KRW");
	                 gbpToJpyRate = conversionGBP.getDouble("JPY");
	                 gbpToUsdRate = conversionGBP.getDouble("USD");

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 }
	 	
	    public void setConversionEventListener(ConversionEventListener listener) {
	        this.conversionEventListener = listener;
	    }
 
		@Override
		public double convertir(String datoBase, String datoAConvertir, double cantidad) {double resultado = 0.0;
			if (datoBase.equals("Peso Colombiano")||datoBase.equals("Colombian peso")) {
	            if (datoAConvertir.equals("Dolar Estadounidense")||datoAConvertir.equals("U.S. dollar")) {
	            	resultado= cantidad *copToUsdRate;	
	            } else if (datoAConvertir.equals("Euro")||datoAConvertir.equals("Euro")) {
	            	resultado=  cantidad *copToEurRate;
	            } else if (datoAConvertir.equals("Yen Japones")||datoAConvertir.equals("Japanese Yen")) {
	            	resultado=  cantidad * copToJpyRate;
	            } else if (datoAConvertir.equals("Won-Sur Coreano")||datoAConvertir.equals("Won-South Korean")) {
	            	resultado=  cantidad * copToKrwRate;
	            }else if (datoAConvertir.equals("Libra Esterlina")||datoAConvertir.equals("Pound Sterling")) {
	            	resultado=  cantidad * copToGbpRate;
	            }
	            
	        } else if (datoBase.equals("Dolar Estadounidense")||datoBase.equals("U.S. dollar")) {
	            if (datoAConvertir.equals("Peso Colombiano")||datoAConvertir.equals("Colombian peso")) {
	            	resultado=  cantidad *usdToCopRate; 
	            } else if (datoAConvertir.equals("Euro")||datoAConvertir.equals("Euro")) {
	            	resultado=  cantidad *usdToEurRate;
	            } else if (datoAConvertir.equals("Yen Japones")||datoAConvertir.equals("Japanese Yen")) {
	            	resultado=  cantidad *usdToJpyRate;
	            } else if (datoAConvertir.equals("Won-Sur Coreano")||datoAConvertir.equals("Won-South Korean")) {
	            	resultado=  cantidad *usdToJKrwRate;
	            }else if (datoAConvertir.equals("Libra Esterlina")||datoAConvertir.equals("Pound Sterling")) {
	            	resultado=  cantidad *usdToGbpRate;
	            }
	            
	        } else if (datoBase.equals("Euro")||datoBase.equals("Euro")) { 
	            if (datoAConvertir.equals("Peso Colombiano")||datoAConvertir.equals("Colombian peso")) {
	            	resultado=  cantidad *eurToCopRate;
	            } else if (datoAConvertir.equals("Dolar Estadounidense")||datoAConvertir.equals("U.S. dollar")) {
	            	resultado=  cantidad *eurToUsdRate;
	            } else if (datoAConvertir.equals("Yen Japones")||datoAConvertir.equals("Japanese Yen")) {
	            	resultado=  cantidad *eurToJpyRate;
	            } else if (datoAConvertir.equals("Won-Sur Coreano")||datoAConvertir.equals("Won-South Korean")) {
	            	resultado=  cantidad *eurToKrwRate;
	            } else if (datoAConvertir.equals("Libra Esterlina")||datoAConvertir.equals("Pound Sterling")) {
	            	resultado=  cantidad *eurToGbpRate;
	            }
	            
	        } else if (datoBase.equals("Yen Japones")||datoBase.equals("Japanese Yen")) {
	            if (datoAConvertir.equals("Peso Colombiano")||datoAConvertir.equals("Colombian peso")) {
	            	resultado=  cantidad *jpyToCopRate;
	            } else if (datoAConvertir.equals("Dolar Estadounidense")||datoAConvertir.equals("U.S. dollar")) {
	            	resultado=  cantidad *jpyToUsdRate;
	            } else if (datoAConvertir.equals("Euro")||datoAConvertir.equals("Euro")) {
	            	resultado=  cantidad *jpyToEurRate;
	            } else if (datoAConvertir.equals("Won-Sur Coreano")||datoAConvertir.equals("Won-South Korean")) {
	            	resultado=  cantidad *jpyToKrwRate;
	            }else if (datoAConvertir.equals("Libra Esterlina")||datoAConvertir.equals("Pound Sterling")) {
	            	resultado=  cantidad *jpyToGbpRate;
	            }
	            
	        } else if (datoBase.equals("Won-Sur Coreano")||datoBase.equals("Won-South Korean")) {
	            if (datoAConvertir.equals("Peso Colombiano")||datoAConvertir.equals("Colombian peso")) {
	            	resultado=  cantidad *krwToCopRate;
	            } else if (datoAConvertir.equals("Dolar Estadounidense")||datoAConvertir.equals("U.S. dollar")) {
	            	resultado=  cantidad *krwToUsdRate;
	            } else if (datoAConvertir.equals("Euro")||datoAConvertir.equals("Euro")) {
	            	resultado=  cantidad *krwToEurRate;
	            } else if (datoAConvertir.equals("Yen Japones")||datoAConvertir.equals("Japanese Yen")) {
	            	resultado=  cantidad *krwToJpyRate;
	            }else if (datoAConvertir.equals("Libra Esterlina")||datoAConvertir.equals("Pound Sterling")) {
	            	resultado=  cantidad *krwToGbpRate;
	            }  
	        } else if (datoBase.equals("Libra Esterlina")||datoBase.equals("Pound Sterling")) {
	            if (datoAConvertir.equals("Peso Colombiano")||datoAConvertir.equals("Colombian peso")) {
	            	resultado=  cantidad *gbpToCopRate;
	            } else if (datoAConvertir.equals("Dolar Estadounidense")||datoAConvertir.equals("U.S. dollar")) {
	            	resultado=  cantidad *gbpToUsdRate;
	            } else if (datoAConvertir.equals("Euro")||datoAConvertir.equals("Euro")) {
	            	resultado=  cantidad *gbpToEurRate;
	            } else if (datoAConvertir.equals("Yen Japones")||datoAConvertir.equals("Japanese Yen")) {
	            	resultado=  cantidad *gbpToJpyRate;
	            }else if (datoAConvertir.equals("Won-Sur Coreano")||datoAConvertir.equals("Won-South Korean")) {
	            	resultado=  cantidad *gbpToKrwRate;
	            }  
	        }
			if (conversionEventListener != null) {
		        conversionEventListener.eventoResultado(resultado);
		    }
			return resultado;
		} 
}
