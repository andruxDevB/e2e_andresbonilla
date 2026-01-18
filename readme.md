Prerequisitos.
    - IntelliJ IDEA 2025.1.3
    - Java 17 (como variable de entorno)
    - Maven 3.9.1 (como variable de entorno)
    - Serenity BDD versión 4.2.22

2. Clonar el proyecto
   - git clone https://github.com/andruxDevB/e2e_andresbonilla.git
   
3. Ejecución.
    - mvn clean verify → (desde consola en la raíz del proyecto)
    
4. Se obtiene como resultado
    - target/site/serenity/index.html → reporte de pruebas

OBSERVACION:
    Los datos csv se inyectan desde src/main/java/com/saucedemo/utils/CsvExamples.java