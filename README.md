# Fawry Internship Challenge - E-Commerce System

This project is a solution to the Fawry Rise Journey Full Stack Internship Challenge.

## Overview

The system simulates a simplified e-commerce platform with support for:
- Product definition (name, price, quantity)
- Handling of perishable products with expiration dates
- Handling of shippable products with weight
- Customer shopping cart and checkout process
- Shipping service integration
- Full application of Object-Oriented Programming (OOP) principles

## Features

- Products can be:
  - Perishable (e.g. Cheese, Biscuits)
  - Shippable (e.g. TV)
  - Both perishable and shippable (e.g. Cheese with weight)
  - Non-shippable and non-perishable (e.g. Scratch Cards)

- During checkout:
  - Subtotal and shipping cost are calculated
  - Shipping is handled through a separate ShippingService
  - Errors are raised for:
    - Empty cart
    - Insufficient balance
    - Expired products
    - Quantity exceeding available stock

## Project Structure

- `Product.java` – Abstract base class for all products
- `PerishableProduct.java` – Subclass for expired products
- `ShippableProduct.java` – Implements shippable products
- `PerishableShippableProduct.java` – Combines both traits
- `Shippable.java` – Interface with `getName()` and `getWeight()` methods
- `Customer.java` – Customer model with balance
- `Cart.java` – Handles adding products and cart items
- `ShippingService.java` – Simulates shipping logic
- `CheckoutService.java` – Handles full checkout process and validation
- `Main.java` – Contains test cases that demonstrate all use cases

## How to Run

1. Make sure you have JDK installed (Java 17+ recommended)
2. Open the project folder in VS Code
3. Open `Main.java`
4. Run the file to see console output with all test scenarios

## Test Cases

The `Main.java` file includes multiple test cases covering:

1. Normal successful checkout
2. Expired product handling
3. Quantity exceeding stock
4. Insufficient balance
5. Empty cart
6. Cart with only non-shippable product

## Notes

- Solution written in Java using full OOP concepts
- Shipping cost is calculated as `15 * number of shippable items`
- Output is printed to console
