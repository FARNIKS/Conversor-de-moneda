package Logica;

public class Temperatura  implements Conversor{

	 private ConversionEventListener conversionEventListener;
	    
	    public void setConversionEventListener(ConversionEventListener listener) {
	        this.conversionEventListener = listener;
	    }

		@Override
		public double convertir(String datoBase, String datoAConvertir, double cantidad) {
			double resultado = 0.0;
			if (datoBase.equals("°Kelvin")) {
	            if (datoAConvertir.equals("°Celsius")) {
	            	resultado= cantidad-273.15 ;
	            } else if (datoAConvertir.equals("°Fahrenheit")) {
	            	resultado=  (cantidad-273.15)*9.0/5.0+32 ;
	            }
	        } else if (datoBase.equals("°Celsius")) {
	            if (datoAConvertir.equals("°Kelvin")) {
	            	resultado=  cantidad+273.15;
	            } else if (datoAConvertir.equals("°Fahrenheit")) {
	            	resultado=  (cantidad*9.0/5.0)+32;
	            }
	        } else if (datoBase.equals("°Fahrenheit")) {
	            if (datoAConvertir.equals("°Celsius")) {
	            	resultado=  (cantidad - 32) * 5/9;
	            } else if (datoAConvertir.equals("°Kelvin")) {
	            	resultado=  (cantidad- 32) * 5/9 + 273.15;
	            }
	        } 
			if (conversionEventListener != null) {
		        conversionEventListener.eventoResultado(resultado);
		    }
			return resultado;
		}
	

}
