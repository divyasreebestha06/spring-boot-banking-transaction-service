# 🏦 spring-boot-banking-transaction-service

[![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org)
[![ACID](https://img.shields.io/badge/Financial-ACID_Compliance-red?style=for-the-badge)](src/)

Core Banking Transaction Ledger Service in Java with double-entry bookkeeping and ACID transfer guarantees.

## Financial Invariants
- **Conservation of Value:** Sum of account balances is invariant across transfers.
- **Overdraft Protection:** Strict balance assertions prevent negative balances.
- **Atomic Execution:** Synchronization guards against concurrent double-spending.
