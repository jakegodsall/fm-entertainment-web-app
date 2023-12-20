export default function Button({ children, handleFormDataSubmitted }) {
    // const handleSubmit = (event) => {
    //     handleFormDataSubmitted(event);
    // };

    return (
        <button
            type="submit"
            className="w-full rounded-[0.6rem] bg-primary-red p-[1.4rem] text-[1.5rem] font-extralight"
        >
            {children}
        </button>
    );
}
