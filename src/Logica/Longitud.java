package Logica;


public class Longitud  implements  Conversor {
	
    private ConversionEventListener conversionEventListener;
    
    public void setConversionEventListener(ConversionEventListener listener) {
        this.conversionEventListener = listener;
    }

	@Override
	public double convertir(String datoBase, String datoAConvertir, double cantidad) {
		double resultado = 0.0;
		if (datoBase.equals("Centimetro")||datoBase.equals("Centimeter")) {
            if (datoAConvertir.equals("Kilometro")||datoAConvertir.equals("Kilometer")) {
            	resultado= cantidad / 100000;
            	
            } else if (datoAConvertir.equals("Metro")||datoAConvertir.equals("Meter")) {
            	resultado=  cantidad / 100;
            } else if (datoAConvertir.equals("Milimetro")||datoAConvertir.equals("Milimeter")) {
            	resultado=  cantidad * 10;
            }
        } else if (datoBase.equals("Milimetro")||datoBase.equals("Milimeter")) {
            if (datoAConvertir.equals("Centimetro")||datoAConvertir.equals("Centimeter")) { 
            	resultado=  cantidad / 10;
            } else if (datoAConvertir.equals("Kilometro")||datoAConvertir.equals("Kilometer")) {
            	resultado=  cantidad / 1000000;
            } else if (datoAConvertir.equals("Metro")||datoAConvertir.equals("Meter")) {
            	resultado=  cantidad / 1000;
            }
        } else if (datoBase.equals("Metro")||datoBase.equals("Meter")) { 
            if (datoAConvertir.equals("Kilometro")||datoAConvertir.equals("Kilometer")) {
            	resultado=  cantidad / 1000;
            } else if (datoAConvertir.equals("Centimetro")||datoAConvertir.equals("Centimeter")) {
            	resultado=  cantidad * 100;
            } else if (datoAConvertir.equals("Milimetro")||datoAConvertir.equals("Milimeter")) {
            	resultado=  cantidad * 1000;
            }
        } else if (datoBase.equals("Kilometro")||datoBase.equals("Kilometer")) {
            if (datoAConvertir.equals("Metro")||datoAConvertir.equals("Meter")) {
            	resultado=  cantidad * 1000;
            } else if (datoAConvertir.equals("Centimetro")||datoAConvertir.equals("Centimeter")) {
            	resultado=  cantidad * 100000;
            } else if (datoAConvertir.equals("Milimetro")||datoAConvertir.equals("Milimeter")) {
            	resultado=  cantidad * 1000000;
            }
        }
		if (conversionEventListener != null) {
	        conversionEventListener.eventoResultado(resultado);
	    }
		return resultado;
	} 
}
