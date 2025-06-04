
    public class ObserverGasolina implements Observer {
        @Override
        public void update(Coche coche) {
            if (coche.gasolina < 10) {
                View.mensajeObserver("[OBSERVER] Gasolina baja, respostar");
            }
        }
    }
