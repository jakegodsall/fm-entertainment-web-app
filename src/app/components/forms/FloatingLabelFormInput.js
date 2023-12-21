export default function FloatingLabelFormInput({
    htmlFor,
    label,
    type,
    value,
    onBlur,
    onChange,
    errorFlag,
    errorMessage,
}) {
    return (
        <div>
            <div className="relative flex flex-col border-b-[0.1rem] border-grey-blue">
                <input
                    type={type}
                    name={htmlFor}
                    className="peer block w-full appearance-none bg-inherit px-2.5 pb-2.5 pt-5 text-[1.5rem] text-gray-900 text-grey-blue focus:outline-none focus:ring-0 dark:text-white dark:focus:border-blue-500"
                    placeholder=" "
                    id={htmlFor}
                    onBlur={(event) => onBlur(htmlFor, event)}
                    onChange={(event) => onChange(htmlFor, event)}
                    value={value}
                />
                <label
                    htmlFor={htmlFor}
                    className="absolute start-2.5 top-4 z-10 origin-[0] -translate-y-8 scale-75 transform text-[1.5rem] text-grey-blue duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:-translate-y-8 peer-focus:scale-75  rtl:peer-focus:left-auto rtl:peer-focus:translate-x-1/4"
                    id="email"
                >
                    {label}
                </label>
            </div>
            <div
                className={
                    errorFlag
                        ? "h-[2.5rem] opacity-100 transition-all duration-500"
                        : "h-0 overflow-hidden opacity-0 transition-all duration-500"
                }
            >
                <p className="px-[0.7rem] pt-[0.5rem] text-[1.2rem] text-primary-red">
                    {errorMessage}
                </p>
            </div>
        </div>
    );
}
