package io.github.gustacodes.icompras.faturamento.bucket;

import io.github.gustacodes.icompras.faturamento.config.props.MinioProps;
import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class BucketService {

    private final MinioClient client;
    private final MinioProps props;

    public void upload(BucketFile file) {
        try {
            var object = PutObjectArgs
                    .builder()
                    .bucket(props.getBucketName())
                    .object(file.name())
                    .stream(file.is(), file.size(), -1)
                    .contentType(file.type().toString())
                    .build();
            client.putObject(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getUrl(String fileName) {
        try {
            var object = GetPresignedObjectUrlArgs
                    .builder()
                    .method(Method.GET)
                    .bucket(props.getBucketName())
                    .object(fileName)
                    .expiry(1, TimeUnit.HOURS)
                    .build();
            return client.getPresignedObjectUrl(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
