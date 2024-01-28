# SyncTask

## Público al que va dirigido

La aplicación va dirigida a personas que trabajan en proyectos, ya sean autónomos, empleados o estudiantes. Se trata de personas que necesitan organizar y gestionar sus tareas y proyectos de forma eficiente.

## Diseño

### Colores
![Colores SyncTask](https://github.com/MSebas55/AppGestionProyectos/blob/main/colores.png)

Los colores utilizados en la aplicación son los siguientes:

-   **Primario:**  #7DCA6A (Verde claro)
-   **Secundario:**  #D05353 (Rosa pastel)
-   **Terciario:**  #6BB5BF (Azul intenso)

Estos colores se han elegido para transmitir una sensación de energía y productividad. El azul intenso se asocia a la confianza y la seguridad, el rosa pastel a la creatividad y la innovación, y el verde claro a la esperanza y el optimismo.

### Fuentes

Las fuentes utilizadas en la aplicación son las siguientes:

-   **Título:**  Roboto Slab
-   **Cuerpo:**  Roboto

Estas fuentes son claras y legibles, lo que facilita la lectura de los textos en la aplicación.

### Paradigma de Material

La aplicación utiliza el paradigma de Material3 con un tema custom. El tema custom se ha creado para adaptar los colores y fuentes de la aplicación a los criterios definidos en la sección de diseño.

## Casos de uso

Los casos de uso de la aplicación son los siguientes:

-   **Registro y inicio de sesión:**  El usuario se registra en la aplicación y crea una cuenta. También puede iniciar sesión con una cuenta existente.
-   **Creación de proyectos:**  El usuario crea nuevos proyectos. Cada proyecto puede tener un nombre, una descripción y una fecha de finalización.
-   **Adición / gestión de tareas a proyectos**  El usuario creador añade tareas a los proyectos. Cada tarea puede tener un título, una descripción, una fecha de vencimiento y un estado.
-   **Edición de proyectos y tareas:**  El usuario puede editar los proyectos y las tareas existentes.
-   **Actualización de archivos del proyecto:**  El usuario puede editar, añadir o eliminar los archivos del proyecto.
-   **Actualización de la aplicación:**  Los desarrolladores pueden realizar cambios en la aplicación.
-   **Visualización de proyectos y tareas:**  El usuario puede visualizar los proyectos y las tareas en una lista o en un calendario.
-   **Corrección de errores:**  Los desarrolladores pueden corregir fallos de la aplicación.

![Casos de uso SyncTask](https://github.com/MSebas55/AppGestionProyectos/blob/main/casos%20de%20uso.png)

Cada caso de uso incluye una o más llamadas a la API Rest. Por ejemplo, el caso de uso de creación de proyectos incluye una llamada a la API para crear un nuevo proyecto.

## Actividades android y organización

La aplicación se compone de las siguientes actividades:

-  **SplashScreenActivity:** Muestra el Splash Screen que posee nuestra app con el logo de dicha app.
-   **MainActivity:**  Actividad principal de la aplicación. Se encarga de mostrar la pantalla de inicio.
-   **LoginActivity:**  Actividad para el registro y el inicio de sesión de usuarios.
-   **ProjectListActivity:**  Actividad para la visualización de la lista de proyectos.
-   **ProjectDetailsActivity:**  Actividad para la visualización de los detalles de un proyecto.
-   **TaskListActivity:**  Actividad para la visualización de la lista de tareas de un proyecto.
-   **TaskDetailsActivity:**  Actividad para la visualización de los detalles de una tarea.

La organización de la aplicación se basa en el uso de layouts, fragments y recycler views. Por ejemplo, la lista de proyectos se muestra en un recycler view.

## Diseño de Figma

![Figma SyncTask](https://github.com/MSebas55/AppGestionProyectos/blob/main/Figma%20SyncTask.png)

La imagen que se ha proporcionado muestra una serie de pantallas de la aplicación realizadas en Figma. Las pantallas mostradas son las siguientes:

-   **Pantalla de inicio:**  La pantalla de inicio muestra el nombre de la aplicación y un botón para iniciar sesión.
-   **Pantalla de registro:**  La pantalla de registro permite al usuario crear una nueva cuenta.
-   **Pantalla de proyectos:**  La pantalla de proyectos muestra una lista de los proyectos del usuario.
-   **Pantalla de detalles de un proyecto:**  La pantalla de detalles de un proyecto muestra la información del proyecto, como el nombre, la descripción y la fecha de finalización.
-   **Pantalla de tareas:**  La pantalla de tareas muestra una lista de las tareas del proyecto seleccionado.
-   **Pantalla de detalles de una tarea:**  La pantalla de detalles de una tarea muestra la información de la tarea, como el título, la descripción, la fecha de vencimiento y el estado.

La imagen también muestra los colores y fuentes utilizados en la aplicación.

## Compatibilidad

La aplicación está diseñada para funcionar en dispositivos Android con Android 7.0 o superior.

## Contacto

Si tienes alguna pregunta o comentario, puedes contactar con el desarrollador en las siguientes direcciones de correo electrónico: calimandrucsebas@gmail.com o alesdo2003@gmail.com
> Hecho por Alberto Escamilla & Sebastián Calimandruc
