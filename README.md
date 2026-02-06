# Complete DevSecOps CI/CD Pipeline
Multi-AZ Amazon EKS + Jenkins + Trivy + SonarQube + ECR + GitHub

This project demonstrates a complete end-to-end DevSecOps CI/CD pipeline built on AWS using Amazon EKS (Multi-AZ) for high availability and scalability. The pipeline integrates security at every stage of the software delivery lifecycle, following DevSecOps best practices.

Source code is managed in GitHub, while Jenkins acts as the CI/CD orchestrator to automate build, test, security scanning, containerization, and deployment. SonarQube is used for static code analysis (SAST) to ensure code quality and detect vulnerabilities early. Trivy performs container image vulnerability scanning before deployment. Docker images are securely stored in Amazon ECR, and validated images are deployed to EKS.

The goal of this project is to showcase how CI/CD + Security + Cloud-Native Kubernetes can work together to deliver secure, reliable, and production-ready applications.

## Topics Covered
- End-to-end DevSecOps pipeline
- Multi-AZ Amazon EKS for high availability
- Automated CI/CD using Jenkins
- SonarQube for static code analysis (SAST)
- Trivy for container image vulnerability scanning
- Secure image storage using Amazon ECR
- GitHub-based source control and automation

## Key Learning Points
- Build a complete end-to-end DevSecOps CI/CD pipeline on AWS using Amazon EKS (Multi-AZ) for HA and scalability.
- Integrate security at every stage of the software delivery lifecycle following DevSecOps best practices.
- Use GitHub for source control and Jenkins to automate build, test, security scanning, containerization, and deployment.
- Apply SonarQube for SAST to ensure code quality and detect vulnerabilities early.
- Use Trivy to scan container images for vulnerabilities before deployment.
- Store Docker images securely in Amazon ECR and deploy validated images to EKS.
- Demonstrate how CI/CD + Security + Cloud-Native Kubernetes work together to deliver secure, reliable, production-ready applications.
