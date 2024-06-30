package gondor.chic.ws_gondor.metier.modele;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        Connection connection = null;
        try {
            connection = session
                    .getJdbcCoordinator()
                    .getLogicalConnection()
                    .getPhysicalConnection();

            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery("SELECT nextval('sClient')");
                if (rs.next()) {
                    int nextValue = rs.getInt(1);
                    return "CL" + nextValue;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to generate custom ID", e);
        }
        return null;
    }
}