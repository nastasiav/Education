package org.my.edy.vt;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor
public final class Result {
    long time;
    List<String> result;
}
