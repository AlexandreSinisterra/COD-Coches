# Cambios de Programa diferencias de esquema de clase

1. adapte un poco el codigo de los esquemas al del programa
2. cambios de nombre de funciones, al poder poner model. y controller. pude llamarlos de la misma forma y tmb cambie el nombre de algunas otras funciones para adaptarlas.
3. ademas tuve que crear funciones de pedir litros y metros pero son iguales a las de los mtros etc x eso no las explique
4. tuve que modificar la clase cohce para añadir metros y gasolina
5. modifique la clase mostrar coche para que me salieran los nuevos datos
6. modifique el menu de la view




# Estructura del programa con arquitectura MVC

Iniciamos el programa desde el archivo `App`, que se encargará de llamar a la **View**.

Al principio, se cargarán todos los datos de los coches en el **Model** que se hayan registrado anteriormente, leyendo un documento de texto. Esto se realizará mediante una función de carga de coches que leerá el archivo `.txt` y guardará los datos en un `ArrayList` de objetos tipo `Coche`.

En la **View** se encontrará el menú donde el usuario interactuará con el programa. Aquí estarán todos los `outputs` e `inputs` del usuario. La vista interactuará con el usuario y, en función de sus acciones, llamará a funciones del **Controller**, como por ejemplo la de cambiar la velocidad de un coche.

El **Controller** será el encargado de recibir las instrucciones desde la View, y comunicarse con el **Model** para cambiar los datos o solicitar información. Si se necesita mostrar datos al usuario, el Controller se los enviará a la View para que esta los muestre.

Cuando queramos salir del programa, el **Model** guardará los datos de los coches que están contenidos en el `ArrayList` en el archivo `.txt`.

