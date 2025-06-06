# Apklis API

Librería creada en Java para comprobar si hay nuevas versiones de su aplicación  
en la tienda de aplicaciones cubana **Apklis**.

## Funciones

- [x] Comprobar si hay actualizaciones de su APK.
- [ ] Generar URL de descarga de su aplicación (para apps que no sean de pago).
- [ ] Comprobar compras de aplicaciones en la tienda.

## Uso 

*  En su `settings.gradle` agregue:
```groovy
repositories {
   mavenCentral()
    maven { url 'https://jitpack.io' }
}
```

* En su `build.gradle` agregue:
```groovy
implementation 'com.github.san2ro:apklisapi:1.0.0'
```

* En su  `MainActivity` agregue:
```java
Apklis.checkUpdate(this.getPackageName(),
       response ->{
   // obtiene información de la aplicación 
   }, error ->{
  // capturar errores ocurridos 
 });
```

Código de [ejemplo](https://github.com/san2ro/apklisapi/blob/main/app/src/main/java/com/example/apklis/MainActivity.java) 


## Contacto

- 📧 Correo: [alessandroguez98@gmail.com](mailto:alessandroguez98@gmail.com)  
- 🐦 Twitter: [@esalessandrx](https://twitter.com/esalessandrx)


## Licencia 
```
MIT License

Copyright (c) 2025 Qreativo 

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```