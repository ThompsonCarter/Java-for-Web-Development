// Add Spring Security and configure in-memory users (USER, ADMIN).

// Secure endpoints:
// GET /api/tasks → any authenticated user.
// POST/PUT/DELETE /api/tasks → only ROLE_ADMIN.

// Implement JWT for token-based auth:
// Add /auth/login endpoint.
// Protect /api/** with JwtFilter.

// Demo OAuth 2 by configuring an authorization server in the same app (for learning), then using a simple HTML/JS client to request and use tokens.

// Test CSRF on a small web form for creating tasks (session-based) and confirm safe operation.