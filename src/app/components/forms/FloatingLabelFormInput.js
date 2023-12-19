export default function FloatingLabelFormInput({ htmlFor, label }) {
    return (
        <div className="relative flex flex-col border-b-[0.1rem] border-grey-blue">
            <input
                type="text"
                name="email"
                className="peer block w-full appearance-none bg-inherit px-2.5 pb-2.5 pt-5 text-[1.5rem] text-gray-900 text-grey-blue focus:outline-none focus:ring-0 dark:text-white dark:focus:border-blue-500"
                placeholder=" "
                id={htmlFor}
            />
            <label
                htmlFor={htmlFor}
                className="absolute start-2.5  top-4 z-10 origin-[0] -translate-y-8 scale-75 transform text-[1.5rem] text-grey-blue duration-300 peer-placeholder-shown:translate-y-0 peer-placeholder-shown:scale-100 peer-focus:-translate-y-8 peer-focus:scale-75  rtl:peer-focus:left-auto rtl:peer-focus:translate-x-1/4"
                id="email"
            >
                {label}
            </label>
        </div>
    );
}
