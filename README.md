Calculadora de Índice de Masa Corporal (IMC) - Ejercicio 1 

Descripción del ProyectoAplicación móvil desarrollada en Kotlin y Jetpack Compose que permite a los usuarios calcular su Índice de Masa Corporal (IMC) al ingresar su peso (kg) y altura (cm). 
La aplicación clasifica el resultado según los estándares de la Organización Mundial de la Salud (OMS) y proporciona un feedback visual mediante un código de colores.

Objetivo Académico: Evaluar la implementación de la arquitectura MVVM (Model-View-ViewModel) y la gestión de estados reactivos en una aplicación Android con lógica de negocio. 

Arquitectura y Stack Tecnológico

El proyecto está diseñado bajo el patrón MVVM con el siguiente stack:Arquitectura: Patrón MVVM (Model-View-ViewModel).Lenguaje: Kotlin.Framework UI: Jetpack Compose.Gestión de Estado: MutableStateOf y 
ViewModel. 

Estructura del Código

El código sigue la estructura de paquetes requerida:ComponenteArchivo ClaveResponsabilidad PrincipalModelImcResult.kt

Estructura de datos para el resultado (IMC, clasificación, color).ViewModelImcViewModel.kt

Contiene toda la lógica de negocio, validaciones y estados reactivos.ViewImcScreen.kt

Interfaz de usuario que consume los estados del ViewModel. 

Funcionalidades ImplementadasSe cumplieron todos los requisitos del ejercicio:Cálculo de IMC: Utiliza la fórmula IMC = peso (kg) / [altura (m)]².

Conversión: 

Convierte la altura ingresada de centímetros a metros para el cálculo.Clasificación OMS: Clasifica el resultado en categorías como Bajo peso, Peso normal, Sobrepeso u Obesidad.

Feedback Visual: El resultado cambia el color de fondo según la clasificación obtenida.Validación y Errores: Valida campos vacíos y datos no numéricos, 
mostrando mensajes de error.Controles: Incluye botones funcionales para CALCULAR y LIMPIAR los campos de entrada. 

Cómo Ejecutar el ProyectoClonar/Descargar el Repositorio: Descarga el proyecto de GitHub.

Abrir en Android Studio: Abrir la carpeta CalculadoraIMC como un proyecto de Android Studio.Sincronizar Gradle: Esperar a que Gradle complete la sincronización de dependencias.

Ejecutar: Seleccionar un emulador o dispositivo y presionar Run 


<img width="1097" height="616" alt="image" src="https://github.com/user-attachments/assets/67d3379b-8316-4d38-bea1-864ffd9282ce" />
<img width="1097" height="615" alt="image" src="https://github.com/user-attachments/assets/269316b4-1b3c-4441-a955-face00a3d80b" />
<img width="1107" height="616" alt="image" src="https://github.com/user-attachments/assets/7315e03c-02de-496b-a60d-17b1dfb3594b" />


