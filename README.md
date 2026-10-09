# AI Support Ticket Router

An AI-powered, microservices-based support ticket management system built using Java, Spring Boot, PostgreSQL, and Groq LLM integration.

The platform separates ticket management from AI-powered ticket classification, enabling modular service design, independent responsibilities, and resilient inter-service communication.

## Key Engineering Objectives

- **Microservices Architecture:** Separate Ticket Service and AI Classifier Service with well-defined responsibilities.
- **REST API Engineering:** Ticket CRUD operations, request validation, pagination, and consistent error responses.
- **AI Integration:** Structured LLM output for ticket intent, sentiment, priority, and suggested support team.
- **Inter-Service Communication:** Reactive HTTP communication using Spring WebClient and DTO-based contracts.
- **Fault Tolerance:** Timeouts, retries, circuit breakers, and fallback responses for AI service failures.
- **Data Persistence:** PostgreSQL integration using Spring Data JPA.
- **API Documentation:** OpenAPI/Swagger documentation for API exploration and testing.
- **Production-Oriented Design:** Centralized exception handling, configuration management, logging, and health monitoring where implemented.

## Technology Stack

- Language: Java
- Backend: Spring Boot, Spring WebFlux WebClient
- Architecture: Microservices, REST APIs
- Database: PostgreSQL
- Persistence: Spring Data JPA, Hibernate
- AI: Groq API, structured JSON output
- Resilience: Resilience4j
- API Documentation: OpenAPI / Swagger
- Testing: JUnit, Mockito
- Development Tools: Maven, Git, GitHub, IntelliJ IDEA, Postman

## Engineering Focus

The primary focus is to build a maintainable and fault-tolerant backend system that handles external AI dependencies, service communication failures, request validation, and predictable API responses.

This project is developed incrementally, with feature-based Git branches, focused commits, and pull requests to maintain traceability and demonstrate the implementation of individual engineering capabilities.
