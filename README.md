# Rest Assured API Tests 🚀

![Java](https://img.shields.io/badge/Java-11+-blue?logo=java)
![TestNG](https://img.shields.io/badge/TestNG-7.x-brightgreen)
![Rest Assured](https://img.shields.io/badge/Rest%20Assured-5.x-orange)
![Build](https://img.shields.io/badge/build-passing-success)

This repository contains **API automation tests** built with [Rest Assured](https://rest-assured.io/) and [TestNG](https://testng.org/).  
The project demonstrates basic **CRUD operations (Create, Read, Update, Delete)** using the public [ReqRes API](https://reqres.in/).

---

## 📌 Features
- API testing with **Rest Assured**
- Test execution using **TestNG**
- Covers basic **CRUD operations**
  - ✅ Get list of users
  - ✅ Create new user
  - ✅ Update existing user
  - ✅ Delete user
- Response validation using **Hamcrest matchers**
- Logging requests & responses for debugging

---

## 🛠️ Tech Stack
- **Java** (JDK 11+ recommended)
- **Rest Assured**
- **TestNG**
- **Maven/Gradle** (for dependency management)

---

## ▶️ Running the Tests

### Using Maven
```bash
mvn clean test
