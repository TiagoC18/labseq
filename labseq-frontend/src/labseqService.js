export const getLabseqValue = async (n) => {
    const response = await fetch(`http://localhost:8080/labseq/${n}`);
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  };
  