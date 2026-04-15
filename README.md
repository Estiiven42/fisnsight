# FinSight — Plataforma de Análisis Financiero Personal con IA

FinSight es una aplicación web que permite a los usuarios gestionar sus finanzas personales de manera inteligente mediante el uso de inteligencia artificial. El sistema facilita el registro de ingresos y gastos, la clasificación automática de transacciones y la generación de predicciones financieras para apoyar la toma de decisiones.

## 🚀 Características principales

- Registro y autenticación de usuarios con JWT
- Gestión de transacciones (ingresos y gastos)
- Clasificación automática de gastos usando IA
- Predicción de comportamiento financiero
- Dashboard con análisis y métricas
- Arquitectura basada en microservicios

## 🧱 Arquitectura

El sistema está compuesto por varios servicios desacoplados:

- **Gateway API:** Punto de entrada central para todas las peticiones
- **Servicio de Autenticación:** Manejo de usuarios y seguridad
- **Servicio de Transacciones:** Lógica de negocio financiera
- **Servicio de IA:** Clasificación y predicción mediante modelos de inteligencia artificial
- **Frontend:** Interfaz web interactiva

## 🛠️ Tecnologías utilizadas

- **Backend:** Spring Boot (Java 21)
- **Frontend:** React + Tailwind CSS
- **IA:** Google Gemini API (Python + Flask)
- **Base de datos:** PostgreSQL
- **Mensajería:** RabbitMQ
- **Infraestructura:** Docker, GitHub Actions, Railway, Vercel

## ☁️ Despliegue

El sistema está diseñado para desplegarse en la nube utilizando servicios modernos y escalables:

- Backend: Railway
- Frontend: Vercel
- Base de datos: Supabase

## 🎯 Objetivo

Brindar a los usuarios una herramienta inteligente que no solo registre sus finanzas, sino que también les proporcione insights, recomendaciones y predicciones para mejorar su salud financiera.

---

## 👨‍💻 Proyecto académico

Este proyecto fue desarrollado como parte de la asignatura **Arquitectura de Sistemas**, integrando conceptos de:

- Microservicios
- APIs REST
- Integración de inteligencia artificial
- Despliegue en la nube
