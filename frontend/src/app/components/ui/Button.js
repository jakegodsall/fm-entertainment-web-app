export default function Button({ children, disabled }) {
    return (
        <button
            type="submit"
            disabled={disabled}
            className={
                disabled
                    ? "w-full cursor-not-allowed rounded-[0.6rem] bg-primary-red p-[1.4rem] text-[1.5rem] font-extralight opacity-50"
                    : "w-full cursor-pointer rounded-[0.6rem] bg-primary-red p-[1.4rem] text-[1.5rem] font-extralight"
            }
        >
            {children}
        </button>
    );
}
