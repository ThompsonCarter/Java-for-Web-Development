
@Component
public class ApiKeyFilter extends OncePerRequestFilter {
    @Value("${api.key}") private String apiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws ServletException, IOException {
        String key = req.getHeader("X-API-KEY");
        if (req.getMethod().matches("POST|PUT|DELETE") && !apiKey.equals(key)) {
            res.sendError(HttpStatus.UNAUTHORIZED.value(), "Invalid API Key");
            return;
        }
        chain.doFilter(req, res);
    }
}
