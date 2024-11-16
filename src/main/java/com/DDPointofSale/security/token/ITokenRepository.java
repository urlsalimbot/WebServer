package com.DDPointofSale.security.token;

import java.util.List;

public interface ITokenRepository {
    public List<Token> getValidTokens();
    public Token findbyToken(String token);
    public void save(Token token);
}
