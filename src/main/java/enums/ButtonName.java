package enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ButtonName {
    PREVIOUS("previous"),
    NEXT("next");

    @Getter
    @NonNull
    private final String buttonClass;
}
