package entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

@EqualsAndHashCode(callSuper = true)
@Data
public class SubcategoryImage extends Entity{
    private Long subcategoryId;
    private String image;

    public SubcategoryImage(Long id, Long subcategoryId, String path) {
        setId(id);
        this.subcategoryId = subcategoryId;
        this.image = path;
    }

    public SubcategoryImage(JSONObject json) {
        setId(json.getLong("id"));
        this.subcategoryId = json.getLong("subcategoryId");
        this.image = json.getString("data");
    }

    public String decompressImage() {
        Inflater inflater = new Inflater();
        byte[] data = Base64.getDecoder().decode(image);
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4096];
        try {
            while(!inflater.finished()) {
                int size = inflater.inflate(tmp);
                outputStream.write(tmp, 0, size);
            }
            outputStream.close();
        } catch (DataFormatException | IOException ex) {
            System.out.println("Error finished decompressing");
        }
        return Base64.getEncoder().encodeToString(outputStream.toByteArray());
    }
}
