## ✅ PASOS COMPLETOS PARA TRABAJAR EN EQUIPO CON GIT Y GITHUB

---

### 1. **Clonar el repositorio (solo la primera vez)**

Si aún no tienes el repositorio en tu PC:

```bash
git clone https://github.com/usuario/repositorio.git
cd repositorio
```

---

### 2. **Actualizar el repositorio antes de trabajar**

> Siempre hacerlo antes de crear una nueva rama o empezar a modificar archivos.

```bash
git checkout main
git pull origin main
```

---

### 3. **Crear y cambiar a tu propia rama**

> Cada compañero debe trabajar en una rama distinta, ejemplo:

```bash
git checkout -b rama-pep
```

☝ Esto crea y cambia a una nueva rama llamada `rama-pep`.

---

### 4. **Hacer cambios y confirmar (commit)**

Después de modificar archivos:

```bash
git add .
git commit -m "Descripción clara del cambio"
```

---

### 5. **Subir la rama a GitHub**

```bash
git push origin rama-pep
```

---

### 6. **Crear el Pull Request (PR)**

1. Ir a GitHub.
2. Te saldrá un botón “**Compare & Pull Request**”.
3. Verifica que se compare contra `main`.
4. Añade un título y descripción del cambio.
5. Haz clic en **Create Pull Request**.

---

### 7. **Revisión y Merge (quien creó el repo o encargado)**

* Si todo está bien, se da clic en **“Merge pull request”**.
* Luego, **opcional:** eliminar la rama en GitHub.

---

### 8. **Actualizar localmente después de un merge**

Todos los compañeros deben hacer esto para tener el proyecto actualizado:

```bash
git checkout main
git pull origin main
```

---

### 9. **Crear una nueva rama desde el nuevo estado actualizado (si van a trabajar de nuevo)**

```bash
git checkout -b nueva-rama
```
## Buenas prácticas del proyecto

- Nombrar clases en mayúscula: Cliente, Producto, Agente.
- Nombrar variables con camelCase: nombreCliente, cedulaAgente.
- Probar el código antes de hacer commit.
- Evitar subir archivos innecesarios como `.idea/` o `.class`.
- Creacion de carpetas. path: src/main/com/inmobilaria

---

## 🔁 RESUMEN GRÁFICO DE FLUJO:

1. `git pull origin main` ✅
2. `git checkout -b tu-rama` 🛠️
3. `git add .` + `git commit -m ""` 💾
4. `git push origin tu-rama` 🚀
5. Crear Pull Request 🧪
6. Revisar + Merge PR 🔍
7. `git pull origin main` (todos actualizan) ♻️
