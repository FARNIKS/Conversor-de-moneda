package Logica;

public class Tiempo  implements Conversor{

	 private ConversionEventListener conversionEventListener;
	    
	    public void setConversionEventListener(ConversionEventListener listener) {
	        this.conversionEventListener = listener;
	    }

		@Override
		public double convertir(String datoBase, String datoAConvertir, double cantidad) {
			double resultado = 0.0;
			if (datoBase.equals("Milisegundo")||datoBase.equals("Millisecond")) {
	            if (datoAConvertir.equals("Segundo")||datoAConvertir.equals("Second")) {
	            	resultado= cantidad / 1000;
	            } else if (datoAConvertir.equals("Minuto")||datoAConvertir.equals("Minute")) {
	            	resultado=  cantidad / 60000;
	            } else if (datoAConvertir.equals("Hora")||datoAConvertir.equals("Hour")) {
	            	resultado=  cantidad /3.6e+6;
	            }else if (datoAConvertir.equals("Dia")||datoAConvertir.equals("Day")) {
	            	resultado=  cantidad /8.64e+7;
	            }
	        } else if (datoBase.equals("Segundo")||datoBase.equals("Second")) {
	            if (datoAConvertir.equals("Milisegundo")||datoAConvertir.equals("Millisecond")) {
	            	resultado=  cantidad *1000;
	            } else if (datoAConvertir.equals("Minuto")||datoAConvertir.equals("Minute")) {
	            	resultado=  cantidad /60;
	            } else if (datoAConvertir.equals("Hora")||datoAConvertir.equals("Hour")) {
	            	resultado=  cantidad /3600;
	            }else if (datoAConvertir.equals("Dia")||datoAConvertir.equals("Day")) {
	            	resultado=  cantidad /86400;
	            }
	        } else if (datoBase.equals("Minuto")||datoBase.equals("Minute")) { 
	            if (datoAConvertir.equals("Milisegundo")||datoAConvertir.equals("Millisecond")) {
	            	resultado=  cantidad *60000;
	            } else if (datoAConvertir.equals("Segundo")||datoAConvertir.equals("Second")) {
	            	resultado=  cantidad *60;
	            } else if (datoAConvertir.equals("Hora")||datoAConvertir.equals("Hour")) {
	            	resultado=  cantidad /60;
	            }else if (datoAConvertir.equals("Dia")||datoAConvertir.equals("Day")) {
	            	resultado=  cantidad /1440;
	            }
	        } else if (datoBase.equals("Hora")||datoBase.equals("Hour")) {
	            if (datoAConvertir.equals("Milisegundo")||datoAConvertir.equals("Millisecond")) {
	            	resultado=  cantidad *3.6e+6;
	            } else if (datoAConvertir.equals("Segundo")||datoAConvertir.equals("Second")) {
	            	resultado=  cantidad *3600;
	            } else if (datoAConvertir.equals("Minuto")||datoAConvertir.equals("Minute")) {
	            	resultado=  cantidad *60;
	            }else if (datoAConvertir.equals("Dia")||datoAConvertir.equals("Day")) {
	            	resultado=  cantidad /24;
	            }
	        }else if (datoBase.equals("Dia")||datoBase.equals("Day")) {
	            if (datoAConvertir.equals("Milisegundo")||datoAConvertir.equals("Milisecond")) {
	            	resultado=  cantidad * 8.64e+7;
	            } else if (datoAConvertir.equals("Segundo")||datoAConvertir.equals("Second")) {
	            	resultado=  cantidad * 86400;
	            } else if (datoAConvertir.equals("Minuto")||datoAConvertir.equals("Minute")) {
	            	resultado=  cantidad * 1440;
	            }else if (datoAConvertir.equals("Hora")||datoAConvertir.equals("Hour")) {
	            	resultado=  cantidad *24;
	            }
	        }
			if (conversionEventListener != null) {
		        conversionEventListener.eventoResultado(resultado);
		    }
			return resultado;
		} 
}
