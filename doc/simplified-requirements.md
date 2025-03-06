# Simplified Sales Order Management System
A learning project for Junior Full-Stack Developers using Spring Boot and Vue + Nuxt

## Tech Stack
- Backend: Spring Boot
- Frontend: Vue 3 + Nuxt
- Database: MySQL (for development simplicity)
- Docker compose

## 1. Simplified Features

### Core Features
1. Customer Management
   - View customer list
   - Create new customer
   - View customer details
   - Update customer balance

2. Product Management
   - View product list
   - Create new product
   - Update product stock
   - Update product price

3. Sales Order
   - Create new order
   - View order list
   - View order details
   - Add order line
   - remove order line

### Learning Focus Areas
- REST API development
- Basic CRUD operations
- Form handling and validation
- Data table implementation
- State management
- Error handling

## 2. Simplified Domain Model

### Customer
- id (Long)
- code (String, unique)
- name (String)
- balance (Double)

### Product
- id (Long)
- code (String, unique)
- name (String)
- price (Double)
- stockQuantity (Integer)

### SalesOrder
- id (Long)
- orderNumber (String, unique)
- orderDate (LocalDateTime)
- customerId (Long)
- status (String: NEW, COMPLETED)
- total (Double)

### OrderLine
- id (Long)
- orderId (Long)
- productId (Long)
- quantity (Integer)
- price (Double)

## 3. Key API Endpoints

### Customer APIs
```
GET    /api/customers
POST   /api/customers
GET    /api/customers/{id}
PUT    /api/customers/{id}/balance
GET    /api/customers/{id}/order
```

### Product APIs
```
GET    /api/products
POST   /api/products
GET    /api/products/{id}
PUT    /api/products/{id}/stock
PUT    /api/products/{id}/price
```

### Order APIs
```
GET    /api/orders
POST   /api/orders
GET    /api/orders/{id}
POST   /api/orders/{id}/lines
DELETE /api/orders/{id}/{lineId}
```

## 4. Simplified Frontend Pages

### Essential Pages
1. Dashboard
   - Simple welcome page
   - Navigation menu
   - Basic stats (total customers, products, orders)

2. Customers
   - Customer list table with pagination
   - Create customer form
   - Customer details view
   - Balance update modal

3. Products
   - Product list table with pagination
   - Create product form
   - Product details view
   - Stock/price update modals

4. Orders
   - Order list table with pagination
   - Create order form
   - Order details view

### Common Components
- Data table component
- Form input components
- Modal component
- Alert/notification component
- Loading spinner

## 5. Basic Validation Rules

### Customer
- Code: Required, unique, max 10 chars
- Name: Required, max 50 chars
- Balance: Non-negative number

### Product
- Code: Required, unique, max 10 chars
- Name: Required, max 50 chars
- Price: Positive number
- Stock: Non-negative integer

### Order
- Customer: Must exist
- Order lines: At least one line
- Quantity: Positive integer
- Available stock: Must be sufficient
- Customer balance: Must be sufficient

## 6. Learning Milestones

### Phase 1: Setup & Basic CRUD
1. Set up Spring Boot project
2. Set up Vue + Nuxt project
3. Implement basic customer management
4. Implement basic product management

### Phase 2: Order Management
1. Create order structure
2. Implement order creation
3. Handle stock validation
4. Handle balance validation

### Phase 3: UI Enhancement
1. Add data tables with pagination
2. Implement modals for updates
3. Add form validations
4. Add error handling

### Phase 4: Optional Enhancements
1. Add search functionality
2. Implement basic reporting
3. Add audit logging
4. Add user authentication

## 7. Common Exceptions to Handle
- EntityNotFoundException
- InsufficientBalanceException
- InsufficientStockException
- DuplicateEntityException
- ValidationException

## Development Tips
1. Use H2 database for easy setup
2. Start with simple validations
3. Focus on one feature at a time
4. Write basic unit tests
5. Use Vue DevTools for debugging
6. Use Postman for API testing
