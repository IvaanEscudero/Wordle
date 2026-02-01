# Wordle Modificado ![Versión de Java](https://img.shields.io/badge/Java-17+-orange.svg) ![Build](https://img.shields.io/badge/Build-Maven-blue.svg)

## Descripción
Esta es una versión personalizada del famoso juego **Wordle**, diseñada para ser jugada por dos personas en el mismo equipo. A diferencia del original, aquí la "inteligencia" la pone el primer jugador al elegir una palabra estratégica para desafiar al segundo.

## 🎮 Cómo Jugar
El juego se divide en dos fases:

1.  **Fase de Configuración (Jugador 1):**
    * Selecciona la dificultad eligiendo la longitud de la palabra (3, 4 o 5 letras).
    * Introduce la palabra secreta.
2.  **Fase de Intento (Jugador 2):**
    * Tiene un máximo de 8 intentos para adivinar la palabra.
    * **Código de colores:**
        * 🟩 **Verde:** La letra está en la palabra y en la posición correcta.
        * 🟨 **Amarillo:** La letra está en la palabra pero en la posición incorrecta.
        * ⬜ **Gris:** La letra no está en la palabra.

## Tecnologías utilizadas
* **Lenguaje:** Java
* **Gestor de proyectos:** Maven
* **Arquitectura:** Modelo-Vista-Controlador (MCV)

## Instalación y Ejecución

Al ser un proyecto de Maven, puedes ejecutarlo desde la terminal o cualquier IDE.

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/IvaanEscudero/Wordle-Multiplayer.git
    ```
2.  **Compilar el proyecto:**
    ```bash
    mvn clean install
    ```
3.  **Ejecutar la aplicación:**
    ```bash
    mvn exec:java -Dexec.mainClass="com.practica.wordle.Wordle"
    ```
