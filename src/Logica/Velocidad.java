package Logica;

public class Velocidad  implements Conversor{

	 private ConversionEventListener conversionEventListener;
	    
	    public void setConversionEventListener(ConversionEventListener listener) {
	        this.conversionEventListener = listener;
	    }

		@Override
		public double convertir(String datoBase, String datoAConvertir, double cantidad) {
			double resultado = 0.0;
			if (datoBase.equals("Pie por segundo")||datoBase.equals("Foot per second")) {
	            if (datoAConvertir.equals("Milla por hora")||datoAConvertir.equals("Miles per hour")) {
	            	resultado= cantidad / 1.467;
	            } else if (datoAConvertir.equals("Metro por segundo")||datoAConvertir.equals("Meters per second")) {
	            	resultado=  cantidad / 3.281;
	            } else if (datoAConvertir.equals("Kilometros por hora")||datoAConvertir.equals("Kilometers per hour")) {
	            	resultado=  cantidad * 1.097;
	            } else if (datoAConvertir.equals("Nudo")||datoAConvertir.equals("Knot")) {
	            	resultado=  cantidad / 1.688;
	            }
	        } else if (datoBase.equals("Milla por hora")||datoBase.equals("Miles per hour")) {
	            if (datoAConvertir.equals("Pie por segundo")||datoAConvertir.equals("Foot per second")) {
	            	resultado=  cantidad *1.467; 
	            } else if (datoAConvertir.equals("Metro por segundo")||datoAConvertir.equals("Meters per second")) {
	            	resultado=  cantidad /2.237;
	            } else if (datoAConvertir.equals("Kilometros por hora")||datoAConvertir.equals("Kilometers per hour")) {
	            	resultado=  cantidad *1.609;
	            } else if (datoAConvertir.equals("Nudo")||datoAConvertir.equals("Knot")) {
	            	resultado=  cantidad /1.151;
	            }
	        } else if (datoBase.equals("Metro por segundo")||datoBase.equals("Meters per second")) { 
	            if (datoAConvertir.equals("Pie por segundo")||datoAConvertir.equals("Foot per second")) {
	            	resultado=  cantidad *3.281;
	            } else if (datoAConvertir.equals("Milla por hora")||datoAConvertir.equals("Miles per hour")) {
	            	resultado=  cantidad *2.237;
	            } else if (datoAConvertir.equals("Kilometros por hora")||datoAConvertir.equals("Kilometers per hour")) {
	            	resultado=  cantidad *3.6;
	            } else if (datoAConvertir.equals("Nudo")||datoAConvertir.equals("Knot")) {
	            	resultado=  cantidad *1.944;
	            }
	        } else if (datoBase.equals("Kilometros por hora")||datoBase.equals("Kilometers per hour")) {
	            if (datoAConvertir.equals("Pie por segundo")||datoAConvertir.equals("Foot per second")) {
	            	resultado=  cantidad /1.097;
	            } else if (datoAConvertir.equals("Milla por hora")||datoAConvertir.equals("Miles per hour")) {
	            	resultado=  cantidad /1.609;
	            } else if (datoAConvertir.equals("Metro por segundo")||datoAConvertir.equals("Meters per second")) {
	            	resultado=  cantidad /3.6;
	            } else if (datoAConvertir.equals("Nudo")||datoAConvertir.equals("Knot")) {
	            	resultado=  cantidad /1.852;
	            }
	        } else if (datoBase.equals("Nudo")||datoBase.equals("Knot")) {
	            if (datoAConvertir.equals("Pie por segundo")||datoAConvertir.equals("Foot per second")) {
	            	resultado=  cantidad * 1.688;
	            } else if (datoAConvertir.equals("Milla por hora")||datoAConvertir.equals("Miles per hour")) {
	            	resultado=  cantidad * 1.151;
	            } else if (datoAConvertir.equals("Metro por segundo")||datoAConvertir.equals("Meters per second")) {
	            	resultado=  cantidad / 1.944;
	            } else if (datoAConvertir.equals("Kilometros por hora")||datoAConvertir.equals("Kilometers per hour")) {
	            	resultado=  cantidad * 1.852;
	            }
	        }
			if (conversionEventListener != null) {
		        conversionEventListener.eventoResultado(resultado);
		    }
			return resultado;
		} 
}
